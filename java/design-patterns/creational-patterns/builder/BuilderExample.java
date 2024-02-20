package builder;

class BuilderExample {

    static class Bmw {

        private String engine;
}

    static class Audi {

        private String engine;
    }

    interface Builder {

        void reset();

        void setEngine(String engine);
    }

    static class BmwBuilder implements Builder {

        private Bmw bmw;

        public BmwBuilder() {
            this.reset();
        }

        @Override
        public void reset() {
            this.bmw = new Bmw();
        }

        @Override
        public void setEngine(String engine) {
            bmw.engine = engine;
        }

        public Bmw getProduct() {

            var product = this.bmw;
            this.reset();

            return product;
        }
    }

    static class AudiBuilder implements Builder {

        private Audi audi;

        public AudiBuilder() {
            this.reset();
        }

        @Override
        public void reset() {
            this.audi = new Audi();
        }

        @Override
        public void setEngine(String engine) {
            audi.engine = engine;
        }

        public Audi getProduct() {

            var product = this.audi;
            this.reset();

            return product;
        }
    }

    static class Director {

        public void constructBMW(Builder builder) {
            builder.reset();
            builder.setEngine("BMW-Engine");
        }

        public void constructAudi(Builder builder) {
            builder.reset();
            builder.setEngine("Audi-Engine");
        }
    }

    static class Application {

        public static void main(String[] args) {

            var director = new Director();

            var bmwBuilder = new BmwBuilder();
            director.constructBMW(bmwBuilder);
            var bmw = bmwBuilder.getProduct();
            System.out.println("BMW: " + bmw.engine);

            var audiBuilder = new AudiBuilder();
            director.constructAudi(audiBuilder);
            var audi = audiBuilder.getProduct();
            System.out.println("Audi: " + audi.engine);

        }
    }
}
