package com.henryxi.designpattern.creational.builder.unconcrete;

public class Car {
    private String name;
    private int height;
    private String color;
    private int wheelNum;

    static class CarBuilder {
        private String name;
        private int height;
        private String color;
        private int wheelNum;

        public CarBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder withHeight(int height) {
            this.height = height;
            return this;
        }

        public CarBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder withWheelNum(int wheelNum) {
            this.wheelNum = wheelNum;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(CarBuilder carBuilder) {
        this.name = carBuilder.name;
        this.color = carBuilder.color;
        this.height = carBuilder.height;
        this.wheelNum = carBuilder.wheelNum;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", wheelNum=" + wheelNum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }
}
