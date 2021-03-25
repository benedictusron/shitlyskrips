/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import core.Connection;
import core.DTNHost;
import core.Message;
import core.Tuple;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JarKom
 */
public class RouteSocialSimilarity implements RoutingDecisionEngine {

    public static final String PUBSUB_NS = "DecisionEngineRouter";
    public static final String ENGINE_SETTING = "decisionEngine";
    public static final String TOMBSTONE_SETTING = "tombstones";
    public static final String CONNECTION_STATE_SETTING = "";

    protected boolean tombstoning;
    protected RoutingDecisionEngine decider;
    protected List<Tuple<Message, Connection>> outgoingMessages;

    protected Set<String> tombstones;

    @Override
    public void connectionUp(DTNHost thisHost, DTNHost peer) {

    }

    @Override
    public void connectionDown(DTNHost thisHost, DTNHost peer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doExchangeForNewConnection(Connection con, DTNHost peer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean newMessage(Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFinalDest(Message m, DTNHost aHost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean shouldSaveReceivedMessage(Message m, DTNHost thisHost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean shouldSendMessageToHost(Message m, DTNHost otherHost, DTNHost thisHost) {

        return true;
    }

    @Override
    public boolean shouldDeleteSentMessage(Message m, DTNHost otherHost) {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean shouldDeleteOldMessage(Message m, DTNHost hostReportingOld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DTNHost thisHost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoutingDecisionEngine replicate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double hitungtanimoto(DTNHost host, DTNHost peer) {
        List<Integer> x = host.getSocialFeature();
        List<Integer> y = peer.getSocialFeature();

//        Double sim = 0.0;
        Double dotProduct = 0.0;
        Double magnitudeA = 0.0;
        Double magnitudeB = 0.0;

        for (int i = 0; i < x.size(); i++) {
//            sim += x.get(i)*y.get(i)/x.get(i)*x.get(i)+y.get(i)*y.get(i)+x.get(i)*y.get(i);
            dotProduct += x.get(i) * y.get(i);
            magnitudeA += x.get(i) * x.get(i);
            magnitudeB += y.get(i) * y.get(i);
        }

        return ((double) dotProduct / (double) (magnitudeA + magnitudeB - dotProduct));
    }
    
//      * @param features1 The first feature map
//     * @param features2 The second feature map
//     * @return The Tanimoto coefficient
//     */                         
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

 
}
