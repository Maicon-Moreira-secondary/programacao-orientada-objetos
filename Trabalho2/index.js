function preload() {
  robotImage = loadImage("robot.png");
}

function setup() {
  createCanvas(windowWidth, windowHeight - 4);
  document.getElementsByTagName("main")[0].style.height = innerHeight + "px";

  robot = new Robot(width / 2, height / 2, 5, 0.02, 20);
}

function draw() {
  background(181, 185, 183);

  robot.simulate();

  // linha ate o alvo e X do alvo
  stroke(0);
  strokeWeight(2);
  drawingContext.setLineDash([5, 5]);
  line(robot.x, robot.y, robot.targetX, robot.targetY);
  drawingContext.setLineDash([]);
  stroke(255, 0, 0);
  line(
    robot.targetX - 15,
    robot.targetY - 15,
    robot.targetX + 15,
    robot.targetY + 15
  );
  line(
    robot.targetX + 15,
    robot.targetY - 15,
    robot.targetX - 15,
    robot.targetY + 15
  );

  // desenhar triangulo de foto
  if (robot.takingPhoto) {
    noStroke();
    beginShape();
    fill(255);
    vertex(robot.x, robot.y);
    vertex(
      robot.x + cos(robot.angleOfPhoto) * robot.velocity * 200,
      robot.y + sin(robot.angleOfPhoto) * robot.velocity * 200
    );
    vertex(
      robot.x + cos(robot.angleOfPhoto + HALF_PI) * robot.velocity * 200,
      robot.y + sin(robot.angleOfPhoto + HALF_PI) * robot.velocity * 200
    );
    endShape(CLOSE);
  }
  
  // imagem do robo
  image(robotImage, robot.x - 50, robot.y - 50, 100, 100);

  // desenhar barra de energia
  noStroke();
  fill(0, 200, 0);
  rect(0, 0, (robot.energy * width) / 2 / 100, 50);
  textAlign(CENTER, CENTER);
  textSize(20);
  textStyle(BOLD);
  fill(0);
  text("Energia: " + floor(robot.energy) + "%", width / 4, 25);

  // barra de status atual
  fill(0);
  rect(width / 2, 0, width / 2, 50);
  fill(255);
  textAlign(LEFT, CENTER);
  text("Status: " + robot.getStatus(), width / 2 + 50, 25);
}

function windowResized() {
  resizeCanvas(windowWidth, windowHeight);
  document.getElementsByTagName("main")[0].style.height = innerHeight + "px";
}
