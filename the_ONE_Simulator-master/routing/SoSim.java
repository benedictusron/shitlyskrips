/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import core.Connection;
import core.DTNHost;
import core.Message;
import core.Settings;
import core.SimClock;
import core.SimScenario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author JarkomOye
 */
public class SoSim implements RoutingDecisionEngine {

    //untuk menyimpan node yang ditemui (yang diitungnya sekali)
    Set<DTNHost> nodeditemui = new HashSet<DTNHost>();
    List<Double> vektorawal = new ArrayList<Double>();
    double tanimoto = 0;
//    Map<DTNHost, List<Integer>> simpanAwal = new HashMap<DTNHost, List<Integer>>(); //Untuk menyimpan social feature yg ditemui
//    Map<DTNHost, List<Double>> simpanSocialFeature = new HashMap<DTNHost, List<Double>>();

    public SoSim(Settings s) {

    }

    public SoSim(SoSim proto) {

    }

    @Override
    public void connectionUp(DTNHost thisHost, DTNHost peer) {

        if (SimClock.getTime() <= 28500) { //jk kurang dari 1728(warmup time)
            nodeditemui.add(peer); //  node yg ditemui akan dimasukin ke set
        }
//        System.out.println(nodeditemui);

        if (SimClock.getTime() > 28500 && vektorawal.isEmpty()) { //jk sudah lebih dari waktu warmpup dan vektor awal kosong
            //inisiasi berapa kali node ketemu node dengan sf yg sama, disini nilai awal 0
            int nationality = 0;
            int language = 0;
            int affiliation = 0;
            int country = 0;
            //inisiasi berapa kali node ketemu dengan semua node, disini nilai awal 0
            double vektornationality = 0;
            double vektorlanguage = 0;
            double vektoraffiliation = 0;
            double vektorcountry = 0;

            BantuHitung bantu = new BantuHitung(); //buat objek untuk manggil rumus bantu bagi biar bisa pecahan

            for (DTNHost node : nodeditemui) {

                if (node.getNationality() == thisHost.getNationality()) {
                    nationality++;
                }
                if (node.getLanguages() == thisHost.getLanguages()) {
                    language++;
                }
                if (node.getAffiliation() == thisHost.getAffiliation()) {
                    affiliation++;
                }
                if (node.getCountry() == thisHost.getCountry()) {
                    country++;
                }
            }

            //hitung vektor , node yg sfnya sama dgn sfnya dibagi dengan node yg ditemui 
            if (!nodeditemui.isEmpty()) {
                vektornationality = bantu.pembagi(nationality, nodeditemui.size());
                vektorlanguage = bantu.pembagi(language, nodeditemui.size());
                vektoraffiliation = bantu.pembagi(affiliation, nodeditemui.size());
                vektorcountry = bantu.pembagi(country, nodeditemui.size());
//              System.out.println(affiliation + "/" + nodeditemui.size()); // untuk cek hasilnya (yg dibagi 2)
//              System.out.println(bantu.pembagi(affiliation, nodeditemui.size()));
            }
            //memasukkan nilai vektor msg2 sf pada vektor awal 
            vektorawal.add(vektornationality);
            vektorawal.add(vektorlanguage);
            vektorawal.add(vektoraffiliation);
            vektorawal.add(vektorcountry);

            //untuk cek vektor awal
//            System.out.println(SimClock.getIntTime());
//            System.out.println(thisHost);
//            System.out.println(vektorawal);
        }

    }

    @Override
    public void connectionDown(DTNHost thisHost, DTNHost peer) {

    }

    @Override
    public void doExchangeForNewConnection(Connection con, DTNHost peer) {

    }

    @Override
    public boolean newMessage(Message m) {
        return true;
    }

    @Override
    public boolean isFinalDest(Message m, DTNHost aHost) {
        return m.getTo() == aHost;
    }

    @Override
    public boolean shouldSaveReceivedMessage(Message m, DTNHost thisHost) {
        return true;
    }

    @Override
    public boolean shouldSendMessageToHost(Message m, DTNHost otherHost, DTNHost thisHost) {

        if (SimClock.getIntTime() >= 28500) { //setelah waktu warmup selesai

            this.tanimoto = hitungtanimoto(thisHost, otherHost);
            
            if (Double.isNaN(this.tanimoto)) { //jk hasil tanimoto NaN maka akan diberikan nilai 0
                this.tanimoto = Math.random()*(1.0 - 0.1)+0.2;
            }
//            System.out.println(thisHost + " >> " + otherHost); //cek node yg mana yg ditemui 
    System.out.println(this.tanimoto); // hasil tanimoto
        }

        DecisionEngineRouter otherRouter = (DecisionEngineRouter) otherHost.getRouter();
        SoSim otherSoSim = (SoSim) otherRouter.getDecisionEngine();

        double ti = this.tanimoto; // memasukan nilai tanimoto ke ti(value)
        if (m.getTo() == otherHost) { //jk yg ditemui adalah destinasi
            return true; // pesan akan dikirim

        } else if (ti < otherSoSim.getTanimoto()) { // jk value lebih kecil dri nilai sim node lain
            this.tanimoto = otherSoSim.getTanimoto(); // maka akan memasukkan nilai tanimoto ke node lainnya

            for (Message mes : otherHost.getMessageCollection()) {//baca pesan yg dibawa node lain
                if (!mes.toString().equals(m)) { // jk tidak ditemukan pesan yg node pengirim bawa
                    return true; // akan dikirim
                }

            }
        }
        return false;
    }

    @Override
    public boolean shouldDeleteSentMessage(Message m, DTNHost otherHost) {
        return false;
    }

    @Override
    public boolean shouldDeleteOldMessage(Message m, DTNHost hostReportingOld) {
        return true;
    }

    @Override
    public void update(DTNHost thisHost) {

    }

    @Override
    public RoutingDecisionEngine replicate() {
        return new SoSim(this);
    }

    public double hitungtanimoto(DTNHost host, DTNHost peer) {
        MessageRouter otherRoute = peer.getRouter();

        DecisionEngineRouter otherDe = (DecisionEngineRouter) otherRoute;

        SoSim otherSoSim = (SoSim) otherDe.getDecisionEngine();

        List<Double> x = getVektorawal();
        List<Double> y = otherSoSim.getVektorawal();

//        List<Integer> x = host.getSocialFeature();
//        List<Integer> y = peer.getSocialFeature();
        BantuHitung bantu = new BantuHitung();

//        double sim = 0.0;
        double dotProduct = 0;
        double magnitudeA = 0;
        double magnitudeB = 0;

//        System.out.println(x.size() + " " + y.size());
        if (!x.isEmpty() && !y.isEmpty()) {

            for (int i = 0; i < x.size(); i++) {
//                sim += x.get(i) * y.get(i) / x.get(i) * x.get(i) + y.get(i) * y.get(i) - x.get(i) * y.get(i);
                dotProduct += bantu.kali(x.get(i), y.get(i));
                magnitudeA += bantu.kali(x.get(i), x.get(i));
                magnitudeB += bantu.kali(y.get(i), y.get(i));
//
////            dotProduct += x.size() * y.size();
////            magnitudeA += x.size() * x.size();
////            magnitudeB += y.size() * y.size();
            }

//            System.out.print(dotProduct + " ");
//            System.out.println(bantu.hitungtanimoto(dotProduct, magnitudeA, magnitudeB));
            return bantu.hitungtanimoto(dotProduct, magnitudeA, magnitudeB);
//            return sim;

        }
        return 0.0;
//        return ((double) dotProduct / (double) (magnitudeA + magnitudeB - dotProduct));
    }

//    public static float calculate(Map features1, Map features2) {
//        Set common = new TreeSet(features1.keySet());
//        common.retainAll(features2.keySet());
//        double xy = 0., x = 0., y = 0.;
//        for (String s : common) {
//            int c1 = features1.get(s), c2 = features2.get(s);
//            xy += c1 * c2;
//        }
//        for (Integer c : features1.values()) {
//            x += c * c;
//        }
//        for (Integer c : features2.values()) {
//            y += c * c;
//        }
//        return (float) (xy / (x + y - xy));
//    }
    public List<Double> getVektorawal() {
        return vektorawal;
    }

    public double getTanimoto() {
        return tanimoto;
    }

}
