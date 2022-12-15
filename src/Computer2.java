
public class Computer2{
    private int serialNumber;
    private String model;

    
    
    public Computer2() {
		super();
	}

	private Computer2(int serialNumber, String model) {
        super();
        this.serialNumber = serialNumber;
        this.model = model;
     
    }
    
    @Override
    public String toString() {
        return "Computer [serialNumber=" + serialNumber + ", model=" + model + "]";
    }
    // 여기가 빌더패턴
    public static class ComputerBulider {
        private int serialNumber;
        private String model;
       
        
        public ComputerBulider setSerialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }
        public ComputerBulider setModel(String model) {
            this.model = model;
            return this;
        }
      
        
        public Computer2 build() {
            Computer2 computer = new Computer2(serialNumber, model);
            return computer;
        }
    }
    
    public static void main(String[] args) {
    	Computer2 computer = new Computer2.ComputerBulider()
    	            .setSerialNumber(0)
    	            .build();
    	  
        System.out.println(computer); //얘는 Null이나 0등 초기화가 됨
        
        //얘는 안됨
        //Computer2 computer2 = new Computer2();
        
        
        
	}
}