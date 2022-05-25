class Robot {
  constructor(x, y, velocity, chanceOfPhoto, stepsPerPhoto) {
    this.x = x;
    this.y = y;
    this.velocity = velocity;
    this.chanceOfPhoto = chanceOfPhoto;
    this.stepsPerPhoto = stepsPerPhoto;

    this.energy = 100;

    this.takingPhoto = false;
    this.stepsTakingPhoto = 0;
    this.angleOfPhoto = random(TWO_PI);
    this.photoStepEnergyConsumption = 0.75;

    this.walking = true;
    this.targetX = random(0, width);
    this.targetY = random(0, height);
    this.movingStepEnergyConsumption = 0.2;

    this.charging = false;
    this.chargingStepEnergyConsumption = -1;
  }

  simulate() {
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
      const xDiff = this.targetX - this.x;
      const yDiff = this.targetY - this.y;
      const angle = atan2(yDiff, xDiff);

      this.x += this.velocity * cos(angle);
      this.y += this.velocity * sin(angle);

      // se robo chegou no alvo, trocar alvo
      if (
        dist(this.x, this.y, this.targetX, this.targetY) <
        this.velocity * 1.1
      ) {
        this.targetX = random(0, width);
        this.targetY = random(0, height);
      }

      // aleatoriamente iniciar acao de tirar foto
      if (random(1) < this.chanceOfPhoto) {
        this.takingPhoto = true;
        this.walking = false;
        this.angleOfPhoto = random(TWO_PI);
        this.stepsTakingPhoto = 0;
      }
    }
  }

  getStatus() {
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
}
