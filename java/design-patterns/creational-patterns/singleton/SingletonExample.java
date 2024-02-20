package singleton;

class SingletonExample {

    static class Car {
        private static Car instance;

        private Car() {
            System.out.println("New car");
        }

        public static Car getInstance() {

            if (Car.instance == null) {
                Car.instance = new Car();
            }

            return Car.instance;
        }

        public void setEngine(String engine) {
            System.out.println("Engine: " + engine);
        }
    }

    static class Application {
        public static void main(String[] args) {

            Car bmw = Car.getInstance();
            bmw.setEngine("BMW-Engine");

            Car audi = Car.getInstance();
            audi.setEngine("Audi-Engine");
        }
    }
}