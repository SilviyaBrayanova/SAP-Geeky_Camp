package sap3homework;


public class StampsTest {
	public static void main(String[] args) {
		StampCollector ivan = new StampCollector("Ivan Petrov");
		ivan.addStamp(new Stamp("Blue Military Stamp", 1953, "China"));
		ivan.addStamp(new Stamp("12 Pence Black", 1851, "Canada"));
	}
	
	public static Serie isInSerie(Stamp stamp, Serie... series) {
		for(Serie serie:series) {
			if(serie.contains(stamp)) {
				return serie;
			}
		}
		return null;
	}
	
	public static JubileeEnvelope isOnJubileeEnvelope(Stamp stamp, JubileeEnvelope... envelopes) {
		for(JubileeEnvelope envelope:envelopes) {
			if(envelope.contains(stamp)) {
				return envelope;
			}
		}
		return null;
	}
}