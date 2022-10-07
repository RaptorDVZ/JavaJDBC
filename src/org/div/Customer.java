package org.div;

public class Customer {
		private int cid;
		private String cName;
		private String loc;
		public Customer() {
			// TODO Auto-generated constructor stub
		}
		public Customer(int cid, String cName, String loc) {
			super();
			this.cid = cid;
			this.cName = cName;
			this.loc = loc;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getcName() {
			return cName;
		}
		public void setcName(String cName) {
			this.cName = cName;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}
		
}
