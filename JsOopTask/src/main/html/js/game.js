var canvasImage = document.getElementById("canvas");
var canvasContext = canvasImage.getContext("2d");

var birdImage = new Image();
var backgroundImage = new Image();
var groundImage = new Image();
var evilBirdImage = new Image();
var houseImage = new Image();

birdImage.src = "img/bird.png";
backgroundImage.src = "img/bg.png";
groundImage.src = "img/fg.png";
evilBirdImage.src = "img/evilBird.png";
houseImage.src = "img/house.png";

var flyAudio = new Audio();
var scoreAudio = new Audio();

flyAudio.src = "audio/fly.mp3";
scoreAudio.src = "audio/score.mp3";

class Obstacle {

    constructor(x, y, gap) {
        this.x = x;
        this.y = y;
        this.gap = gap;
    }

    drawObstacle() {
        canvasContext.drawImage(evilBirdImage, this.x, this.y);
        canvasContext.drawImage(houseImage, this.x, this.y + evilBirdImage.height + this.gap);
    }
}

class Bird {

    constructor(x, y, gravity) {
        this.x = x;
        this.y = y;
        this.gravity = gravity;
    }

    moveUp() {
        this.y -= 35;
        flyAudio.play();
    }

    drawBird() {
        canvasContext.drawImage(birdImage, this.x, this.y);
    }

    falling() {
        this.y += this.gravity;
    }

    hasCrashed(obstacle) {
        var isAboveCeiling = this.y <= 0;
        var isBelowGround = this.y + birdImage.height >= canvasImage.height - groundImage.height;
        var hasReachedObstacle = this.x + birdImage.width >= obstacle.x;
        var hasNotMovedPastObstacle = this.x <= obstacle.x + evilBirdImage.width;
        var isWithinEvilBird = (this.y <= obstacle.y + evilBirdImage.height) && (this.y >= obstacle.y);
        var isWithinHouse = this.y + birdImage.height >= obstacle.y + evilBirdImage.height + obstacle.gap;

        return isAboveCeiling || isBelowGround || (hasReachedObstacle && hasNotMovedPastObstacle && (isWithinEvilBird || isWithinHouse));
    }
}

function generateObstacle() {
    return new Obstacle(canvasImage.width, Math.floor(Math.random() * (canvasImage.height - groundImage.height) * 0.6),
		Math.round(Math.random() * 60 + 90));
}

var obstacles = [];


var score = 0;
var bestScore = 0;
var bird = new Bird(10, 200, 0.8);


function draw() {
    canvasContext.drawImage(backgroundImage, 0, 0);

    for (var i = 0; i < obstacles.length; i++) {
        obstacles[i].drawObstacle();

        obstacles[i].x--;

        if (obstacles[i].x === 80) {
            obstacles.push(generateObstacle());
        }

        if (bird.hasCrashed(obstacles[i])) {
            location.reload();
            return;
        }

        if (obstacles[i].x === 5) {
            score++;
            if (bestScore < score) {
                document.cookie = "bestScore=" + score.toString();
                bestScore = score;
            }
            scoreAudio.play();
        }
    }

    if (obstacles[0].x <= -houseImage.width) {
        obstacles.shift();
    }

    canvasContext.drawImage(groundImage, 0, canvasImage.height - groundImage.height);

    bird.drawBird();

    bird.falling();

    canvasContext.fillStyle = "#FFF";
    canvasContext.font = "24px Verdana";
    canvasContext.fillText("Счет: " + score, 10, canvasImage.height - 60);
    canvasContext.fillStyle = "#FFF";
    canvasContext.font = "24px Verdana";
    canvasContext.fillText("Лучший счет: " + bestScore, 10, canvasImage.height - 20);

    requestAnimationFrame(draw);
}

function startGame() {
    document.getElementById("startButton").style.display = 'none';
    var scoreCookie = document.cookie.trim().split(';').filter(item => item.startsWith("bestScore="))[0]
    bestScore = (scoreCookie !== undefined) ? parseInt(scoreCookie.substring(10)) : 0;
    obstacles[0] = generateObstacle();
    document.addEventListener("keydown", (event) => {
        bird.moveUp();
    });
    draw();
}