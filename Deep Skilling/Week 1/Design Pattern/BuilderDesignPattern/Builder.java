public class Builder {

   private int CPU;
     private int RAM;
    private int Storage;

   private Builder(userBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public void display(){
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " +RAM);
        System.out.println("Storage: " +Storage);
    }




    public static class userBuilder{
        private int CPU;
        private int RAM;
        private int Storage;

        public userBuilder SetCPU(int CPU){
            this.CPU  =CPU;
            return this;
        }

        public userBuilder SetRAM(int RAM){
            this.RAM  =RAM;
            return this;
        }

        public userBuilder SetStorage(int Storage){
            this.Storage  =Storage;
            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }

    public static void main(String[] args) {
        Builder b1 = new Builder.userBuilder()
                .SetCPU(1001)
                .SetRAM(1002)
                .SetStorage(1003)
                .build();

        b1.display();
    }
}

