var cvs = document.getElementById("canvas");
var ctx = cvs.getContext("2d");

var birdImage = new Image();
var bgImage = new Image();
var fgImage = new Image();
var evilBirdImage = new Image();
var houseImage = new Image();

birdImage.src = "img/bird.png";
bgImage.src = "img/bg.png";
fgImage.src = "img/fg.png";
evilBirdImage.src = "img/evilBird.png";
houseImage.src = "img/house.png";

var fly = new Audio();
var score_audio = new Audio();

fly.src = "audio/fly.mp3";
score_audio.src = "audio/score.mp3";

class Obstacle {
	
	constructor(x, y, gap) {
		this.x = x;
		this.y = y;
		this.gap = gap;
	}
	
	drawObstacle() {
		ctx.drawImage(evilBirdImage, this.x, this.y);
		ctx.drawImage(houseImage, this.x, this.y + evilBirdImage.height + this.gap);
	}
}

class Bird {
	
	constructor(x, y, grav) {
		this.x = x;
		this.y = y;
		this.grav = grav;
	}
	
	moveUp() {
		this.y -= 35;
		fly.play();
	}
	
	drawBird() {
		ctx.drawImage(birdImage, this.x, this.y);
	}
	
	falling() {
		this.y += this.grav;
	}
	
	hasCrashed(obstacle) {
		return (this.y + birdImage.height >= cvs.height - fgImage.height) || (this.x + birdImage.width >= obstacle.x
		&& this.x <= obstacle.x + evilBirdImage.width
		&& ((this.y <= obstacle.y + evilBirdImage.height && this.y >= obstacle.y) 
		|| this.y + birdImage.height >= obstacle.y + evilBirdImage.height + obstacle.gap));
	}
}

function generateObstacle() {
	return new Obstacle(cvs.width, Math.floor(Math.random() * (cvs.height - fgImage.height) * 0.6), Math.round(Math.random() * 60 + 90));
}

var obstacles = [];

obstacles[0] = generateObstacle();

var score = 0;
var bird = new Bird(10, 200, 0.8);

document.addEventListener("keydown", (event) => {
	bird.moveUp();
});

function draw() {
	ctx.drawImage(bgImage, 0, 0);

	for(var i = 0; i < obstacles.length; i++) {
		obstacles[i].drawObstacle();

		obstacles[i].x--;

		if(obstacles[i].x == 80) {
			obstacles.push(generateObstacle());
		}

		if(bird.hasCrashed(obstacles[i])) {
			location.reload();
		}

		if(obstacles[i].x == 5) {
			score++;
			score_audio.play();
		}
	}

	ctx.drawImage(fgImage, 0, cvs.height - fgImage.height);
	
	bird.drawBird();

	bird.falling();

	ctx.fillStyle = "#FFF";
	ctx.font = "24px Verdana";
	ctx.fillText("Счет: " + score, 10, cvs.height - 20);

	requestAnimationFrame(draw);
}

houseImage.onload = draw;