import java.util.ArrayList;

public class labReturnListener {
		public String actionPerformed() {
			ArrayList<Station> stations =new ArrayList<Station>();
			Station lab = new Station("lab");
			stations.add(lab);
			stations.get(0).slots.get(0).setBorrowed(true);
			String str=null;
			int a;
			int b = 8;
			for(a=0; a<8; a++) {
				if(stations.get(0).slots.get(a).isBorrowed()==false)
					b--;
			}
			if(b!=0) {
				for(int i=0;i<8;i++) {
					str="Return Succeed";
				}
				
			}else {
				str="Station Full";
			}
			return str;
		}
	}
