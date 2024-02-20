package factorymethod;

class FactoryMethodExample {

    abstract static class Car {

        public abstract Engine setEngine();

        public void buildCar() {
            var engine = setEngine();

            engine.startEngine();
            engine.stopEngine();

            System.out.println("Car was successfully built");
        }
    }

    static class BmwCar extends Car {

        @Override
        public Engine setEngine() {
            return new BmwEngine();
        }
    }

    static class AudiCar extends Car {

        @Override
        public Engine setEngine() {
            return new AudiEngine();
        }
    }

    interface Engine {

        void startEngine();

        void stopEngine();
    }

    static class BmwEngine implements Engine {

        @Override
        public void startEngine() {
            System.out.println("BMW-Engine started!");
        }

        @Override
        public void stopEngine() {
            System.out.println("BMW-Engine stopped!");
        }
    }

    static class AudiEngine implements Engine {

        @Override
        public void startEngine() {
            System.out.println("Audi-Engine started!");
        }

        @Override
        public void stopEngine() {
            System.out.println("Audi-Engine stopped!");
        }
    }

    static class Application {

        public static void main(String[] args) {

            Car audi = new AudiCar();
            Car bmw = new BmwCar();

            audi.buildCar();
            bmw.buildCar();
        }
    }
}
