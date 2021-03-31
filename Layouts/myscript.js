function datetime_clock() {
    today = new Date()
    document.getElementById("time").innerHTML = today.toUTCString()
    setTimeout("datetime_clock()", 1000)
}

var players =
    [
        {
            name: "Геральт из Ривии",
            job: "Ведьмак",
            deck: "Королевства севера",
            description: "Геральт из Ривии много путешествует по миру. Его ремесло позволило ему побывать в самых разных " +
                "странах, и конечно же испытать силу своей колоды против самых разнообразных противников. Колода Геральта " +
                "прошла отбор временем и состоит из сильнейших карт, собранных им со всего света.",
            img: "players/geralt.png",
            rating: 42
        },
        {
            name: "Йеннифер из Венгерберга",
            job: "Чародейка",
            deck: "Нильфгаард",
            description: "Йеннифер отличается аристократической утонченностью в сочетании с твердым характером. Будучи частой " +
                "гостьей светских кругов при королях и императорах, где партии в Гвинт - не редкость, она отточила мастерство " +
                "в соревнованиях с самой высокой знатью.",
            img: "players/yennefer.png",
            rating: 41
        },
        {
            name: "Талер",
            job: "Сапожник",
            deck: "Королевства севера",
            description: "Талер производит впечатление человека простого, но за внешностью заурядного сапожника скрывается " +
                "необыкновенная ловкость ума. Поговаривают, что смышленность Талера обоснована некой тайной " +
                "профессией. Так или иначе, он отличный игрок в Гвинт, даже если произвадит впечатление шулера.",
            img: "players/taler.png",
            rating: 22
        },
        {
            name: "Эмиель Регис Рогеллек Терзиефф-Годфрой",
            job: "Цирюльник",
            deck: "Чудовища",
            description: "Эмиель Регис - человек необыкновенного спокойствия и самообладания. Помимо своей основной деятельности, " +
                "он также помогает путникам, проходящим мимо его дома, будет это мудрый совет, или же медицинская " +
                "помощь. В обмен он лишь слушает истории своих гостей, а также не откажется от партейки в гвинт.",
            img: "players/regis.png",
            rating: 25
        },
        {
            name: "Гюнтер о'Дим",
            job: "Торговец",
            deck: "Чудовища",
            description: "Гюнтер о'Дим является, пожалуй, самым загадочным участником турнира. Никто точно не знает, откуда он, " +
                "каков его интерес в участии, однако он отличается невероятной проницательностью, когда дело касается " +
                "людских желаний. Участникам настоятельно не рекомендуется заключать с ним каких-либо пари.",
            img: "players/gunter.png",
            rating: 50
        },
        {
            name: "Хьялмар ан Крайт",
            job: "Хускарл ярла Ард Скеллиге",
            deck: "Скеллиге",
            description: "Хьялмар с рождения обучался искусству боя. Суровый климат и обычаи скеллигских островов закалили в нём " +
                "воина, но он также обладает добрым сердцем, и всегда рад своим друзьям. Пусть он немного вспыльчив, " +
                "но во время застолий Каэр Трольде он с радостью сыграет с гостями в гвинт, возможно даже без драки.",
            img: "players/hjalmar.png",
            rating: 27
        },
        {
            name: "Золтан Хивай",
            job: "Наемник",
            deck: "Скоя'таэли",
            description: "Золтан Хивай является одним из самых ярких представителей краснолюдов, воплощая храбрость и стойкость вместе " +
                "с дружелюбием и радушием. Будучи наемником, ему приходилось участвовать в походах в самые дали королевств " +
                "севера и дальше, и он как никто знает, как гвинт поддерживает дух в дороге.",
            img: "players/zoltan.png",
            rating: 30
        },
        {
            name: "Аваллак'х",
            job: "Учёный",
            deck: "Скоя'таэли",
            description: "Аваллак'х - необычный участник турнира, и даже по меркам эльфов он необычен. Поговаривают что он является чародеем, " +
                "что он может путешествовать между мирами, что он знает рецепт лучшего супа на севере. Что из этого правда, мы " +
                "не знаем, но одно точно - его ум утвердил его как одного из сильнейших игроков в гвинт.",
            img: "players/avalakh.png",
            rating: 32
        }
    ]

var rating = [
    {
        name: "Геральт из Ривии"
    }
]

function show_players(str) {
    divplayers = document.getElementById("theplayers")
    content = ""
    for (var index in players) {
        if (players[index].name.toLowerCase().includes(str.toLowerCase())) {
            content += "<div class=\"player\"><table>"
            content += "<tr>" +
                "<td rowspan=\"4\"><img src=\"" + players[index].img + "\" height=\"400px\" width=\"300px\"/></td>" +
                "<th>Имя:</th>" +
                "<td>" + players[index].name + "</td>" +
                "</tr>"
            content += "<tr>" +
                "<th>Род деятельности:</th>" +
                "<td>" + players[index].job + "</td>" +
                "</tr>" +
                "<tr>" +
                "<th>Фракция колоды:</th>" +
                "<td>" + players[index].deck + "</td>" +
                "</tr>" +
                "<tr>" +
                "<th>Об игроке:</th>" +
                "<td>" + players[index].description + "</td>" +
                "</tr>"
            content += "</table></div>"
        }
    }
    if (divplayers != null) {
        divplayers.innerHTML = content
    }
}

function players_onload() {
    const searchinputparam = window.location.search.substring(1)
    const params = searchinputparam.split("&")
    var initplayersearch = ""
    for (var p in params) {
        if (params[p].split("=")[0] == "searchinput") {
            initplayersearch = decodeURIComponent(params[p].split("=")[1]).split("+").join(" ")
            break;
        }
    }
    show_players(initplayersearch)
    const searchform = document.getElementById("searchform")
    const searchinput = document.getElementById("searchinput")

    if (searchform != null) {
        searchform.addEventListener('submit', event => {
            event.preventDefault()
            window.history.replaceState(null, null, "?searchinput=" + searchinput.value.split(" ").join("+"))
            show_players(searchinput.value)

        })
        searchform.addEventListener('reset', event => {
            event.preventDefault()
            searchinput.value = ""
            show_players(searchinput.value)

        })
    }
    datetime_clock()
}


var users = [
    {
        login: "admin",
        pass: "admin"
    },
    {
        login: "superadmin",
        pass: "superadmin"
    }
]


function registeronload() {

    const regform = document.getElementById("regform")

    if (regform != null) {
        regform.addEventListener('submit', event => {
            event.preventDefault()
            const logininput = document.getElementsByName("login")[0]
            const loginerror = document.getElementById("loginerror")
            const passwordiinput = document.getElementsByName("password")[0]
            const passworderror = document.getElementById("passworderror")
            const dpasswordinput = document.getElementsByName("d_password")[0]
            const dpassworderror = document.getElementById("dpassworderror")
            loginerror.innerHTML = ""
            passworderror.innerHTML = ""
            dpassworderror.innerHTML = ""
            var checker = /^[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)*@([a-zA-Z0-9_-]+\.)+[a-zA-Z]{2,5}$/;
            if (!logininput.value.match(checker)) {
                loginerror.innerHTML = "Неправильный формат e-mail"
            } else {
                if (passwordiinput.value.length < 8) {
                    passworderror.innerHTML = "Пароль должен содержать не менее 8 символов"
                } else {
                    if (passwordiinput.value != dpasswordinput.value) {
                        dpassworderror.innerHTML = "Пароли должны совпадать"
                    } else {
                        alert("Регистрация успешна!")
                    }
                }
            }
        })
    }
    datetime_clock()
}

function loginonload() {
    const loginform = document.getElementById("login")
    if (loginform != null) {
        loginform.addEventListener('submit', event => {
            event.preventDefault()
            const logininput = document.getElementsByName("login")[0]
            const loginerror = document.getElementById("loginerror")
            const passwordiinput = document.getElementsByName("password")[0]
            const passworderror = document.getElementById("passworderror")
            loginerror.innerHTML = ""
            passworderror.innerHTML = ""
            const founduser = users.find(u => u.login == logininput.value)
            if (founduser == undefined) {
                loginerror.innerHTML = "Неверный e-mail"
            } else {
                if (founduser.pass != passwordiinput.value) {
                    passworderror.innerHTML = "Неверный пароль"
                } else {
                    alert("Добро пожаловать, " + founduser.login)
                    logininput.value = ""
                    passwordiinput.value = ""

                }
            }
        })
    }
    datetime_clock()
}


function ratingonload() {
    var sorted_players = players.slice()
    sorted_players.sort((a, b) => {
        return b.rating - a.rating
    })
    divrating = document.getElementById("rating")
    content = "<table>" + "<tr><th>Место</th><th>Игрок</th><th>Рейтинг</th></tr>"
    for (var index in sorted_players) {
        content += "<tr>" +
            "<td>" + (parseInt(index, 10) + 1).toString() + "</td>" +
            "<td><a href=\"Players.html?searchinput=" + sorted_players[index].name + "\">" + sorted_players[index].name + "</a></td>" +
            "<td>" + sorted_players[index].rating + "</td>" +
            "</tr>"
    }
    content += "</table>"
    if (divrating != null) {
        divrating.innerHTML = content
    }

    datetime_clock()
}

var seed = 1;

function random() {
    var x = Math.sin(seed++) * 10000;
    return x - Math.floor(x);
}

var pairs = []
for (var i = 0; i < players.length - 1; i++) {
    for (var j = i + 1; j < players.length; j++) {
        pairs.push({first: players[i].name, second: players[j].name})
    }
}
pairs.sort((a, b) => {
    return 0.5 - random()
})

function scheduleonload() {
    divschedule = document.getElementById("schedule")
    content = "<table>" + "<tr><th>Игрок 1</th><th>Дата</th><th>Игрок 2</th>"
    starting_day = 1
    starting_month = 9
    starting_year = 1270
    console.log(pairs[0])
    for (var index in pairs) {
        content += "<tr>" +
            "<td>" + pairs[index].first + "</td>" +
            "<td>" + starting_day + "." + starting_month + "." + starting_year + "</td>" +
            "<td>" + pairs[index].second + "</td></tr>"
        starting_day += 1
    }

    content += "</table>"
    if (divschedule != null) {
        divschedule.innerHTML = content
    }

    datetime_clock()
}