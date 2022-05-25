package Trabalho2.Trabalho2Java;

public class Robot {
    private double ambientWidth;
    private double ambientHeight;
    private double x;
    private double y;
    private double velocity;
    private double chanceOfPhoto;
    private double stepsPerPhoto;

    private double energy;

    private boolean takingPhoto;
    private double stepsTakingPhoto;
    private double angleOfPhoto;
    private double photoStepEnergyConsumption;

    private boolean walking;
    private double targetX;
    private double targetY;
    private double movingStepEnergyConsumption;

    private boolean charging;
    private double chargingStepEnergyConsumption;

    public Robot(double ambientWidth, double ambientHeight, double x, double y, double velocity, double chanceOfPhoto,
            double stepsPerPhoto) {
        this.ambientWidth = ambientWidth;
        this.ambientHeight = ambientHeight;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.chanceOfPhoto = chanceOfPhoto;
        this.stepsPerPhoto = stepsPerPhoto;

        this.energy = 100;

        this.takingPhoto = false;
        this.stepsTakingPhoto = 0;
        this.angleOfPhoto = Math.random() * 2 * Math.PI;
        this.photoStepEnergyConsumption = 0.75;

        this.walking = true;
        this.targetX = (double) (Math.random() * ambientWidth);
        this.targetY = (double) (Math.random() * ambientHeight);
        this.movingStepEnergyConsumption = 0.2;

        this.charging = false;
        this.chargingStepEnergyConsumption = -1;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public void simulate() {
        // se estiver com menos de 10% de energia, iniciar carregamento
        if (this.energy < 10) {
            this.charging = true;
            this.walking = false;
            this.takingPhoto = false;
        }

        // se estiver carregando, aumentar energia
        if (this.charging) {
            this.energy -= this.chargingStepEnergyConsumption;
            if (this.energy > 100) {
                this.energy = 100;
                this.charging = false;
                this.walking = true;
            }
        }

        // se estiver tirando foto, pare o robo
        if (this.takingPhoto) {
            this.stepsTakingPhoto++;
            this.energy -= this.photoStepEnergyConsumption;

            if (this.stepsTakingPhoto >= this.stepsPerPhoto) {
                this.takingPhoto = false;
                this.walking = true;
            }
        }

        // se estiver andando, mover o robo

        if (this.walking) {
            this.energy -= this.movingStepEnergyConsumption;
            double xDiff = this.targetX - this.x;
            double yDiff = this.targetY - this.y;
            double angle = Math.atan2(yDiff, xDiff);

            this.x += this.velocity * Math.cos(angle);
            this.y += this.velocity * Math.sin(angle);

            // se robo chegou no alvo, trocar alvo
            if (this.distance(this.x, this.y, this.targetX, this.targetY) < this.velocity * 1.1) {
                this.targetX = (double) (Math.random() * this.ambientWidth);
                this.targetY = (double) (Math.random() * this.ambientHeight);
            }

            // aleatoriamente iniciar acao de tirar foto
            if (Math.random() < this.chanceOfPhoto) {
                this.takingPhoto = true;
                this.walking = false;
                this.angleOfPhoto = Math.random() * 2 * Math.PI;
                this.stepsTakingPhoto = 0;
            }
        }
    }

    public String getStatus() {
        if (this.takingPhoto) {
            return "Tirando foto";
        }
        if (this.charging) {
            return "Carregando";
        }
        if (this.walking) {
            return "Andando";
        }
        return "Deconhecido";
    }

    public double getEnergy() {
        return (double) this.energy;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}