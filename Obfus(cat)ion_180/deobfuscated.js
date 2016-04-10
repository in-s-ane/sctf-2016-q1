// h3y th3r3. i kn0 ur pr0 h3xx0r c0z u f1nded mai s0urc3 c0de
// n0w pr0v3 ur 1337 h3xx0r by f1nd1ng mai fl4g!!11!

var _ = {
    79797503: "random",
    74613026: "charCodeAt",
    34834552: "substring",
    63609979: "toString",
    91489034: "eval",
    40938409: "indexOf",
    // hex encode ascii values
    35725343: function(_9) {
        var _8 = [];
        for (var _a = 0, _b = _9.length; _a < _b; _a++) {
            _8.push(Number(_9.charCodeAt(_a)).toString(16));
        }
        return "0x" + _8.join("");
    },
    37800710: function(_2, _3) {
        var _4 = Math.max(_2.length, _3.length);
        var _7 = _2 + _3;
        var _6 = "";
        for (var _5 = 0; _5 < _4; _5++) {
            _6 += _7.charAt((_2.charCodeAt(_5 % _2.length) ^ _3.charCodeAt(_5 % _3.length)) % _4);
        }
        return _6;
    },
    // Repeat _c _d times
    96871376: function(_c, _d) {
        var _e = "";
        for (var _f = 0; _f < _d; _f++) {
            _e += _c;
        }
        return _e;
    }
};
var $ = [79797503, 63946092, 11794800, 79242618, 21011655, 74357006, 34834552, 1970249, 23372281, 76858911, 76608837, 85905355, 80187674, 44006245, 81649892, 77564063, 99340332, 89584450, 66581494, 18171050, 88003709, 941564184, 48879197, 96871376, 53383051, 63609979, 57123995, 56629147, 97018582, 51233199, 7837649, 35725343, 99304261, 99203757, 60504903, 53414799, 75846878, 65582568, 98890527, 76174246, 40938409, 37800710, 91489034, 23170874, 40969631, 61015781, 30620486, 24914357, 30343924, 15436139]
var a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
function check() {
    var answer = document.getElementById("message").value;
    var correct = (function() {
        try {
            answer = "sctf{w?_iz_mai_fooo0oood??}"
            h = new MersenneTwister(396000);
            e = -983275042;
            l = new MersenneTwister(e);
            l.random();
            l.random();
            l.random();
            o = answer.split("_");
            i = 941574242;
            s = [941574242, 983275042]

            // Gets the hex of the ascii values for the characters in o[1]
            // needs to evaluate to 941564184
            // The value that xor's with s[0] to make 941564184 is 27002, or 0x697a in hex
            // chr(0x69) + chr(0x7a) = "iz"
            // Thus:
            // o[1] = "iz"
            e = -(_[$[31]](o[1]) ^ s[0]);

            if (-e != 941564184) {
                return false;
            }
            // Knowing how xor works, we can reverse for the hex of o[2]
            // e ^ s[1] ^ -48879197
            // 7168361

            // >>> hex(7168361)
            // '0x6d6169'
            // >>> chr(0x6d) + chr(0x61) + chr(0x69)
            // "mai"
            // Thus:
            // o[2] = "mai"
            e ^= (_[$[31]](o[2]) ^ s[1]);
            if (-e != 48879197) {
                return false;
            }
            e -= 892095131;

            t = new MersenneTwister(30675.304855860846);
            h.random();
            a = l.random();
            t.random();
            y = [1, 2, 4];
            // Remove first 4 characters ("sctf{")
            o[0] = o[0].substring(5);

            // Remove last char from o[3] ("}")
            o[3] = o[3].substring(0, o[3].length - 1);
            u = 31251000;

            // Repeat "1" x times and xor with the hex representation of the ascii codes
            a = parseInt(_[$[23]]("1", Math.max(o[0].length, o[3].length)), 3) ^ eval(_[$[31]](o[0]));

            r = (h.random() * l.random() * t.random()) / (h.random() * l.random() * t.random());
            e ^= -8;
            r = (h.random() / l.random() / t.random()) / (h.random() * l.random() * t.random());
            e ^= 15;

            // a += "0x??????"
            a += _[$[31]](o[3].substring(o[3].length - 2)).split("x")[1];
            d = parseInt(a, 16) == "65531" + o[3].charCodeAt(o[3].length - 3).toString(16) + "538462015";
            i = 255;

            // Repeat o[3][-4] 3 times, which is equal to o[3][1:4]
            n = (f = _[$[23]](o[3].charAt(o[3].length - 4), 3)) == o[3].substring(1, 4);
            g = 111;

            // Repeat o[3][3] 3 times, which is equal to o[3][5:8]
            t = _[$[23]](o[3].charAt(3), 3) == o[3].substring(5, 8) && (o[3].charCodeAt(1)-2) * o[0].charCodeAt(0) == 12971;

            h = "f0";
            i = o[3].split(f).join("");
            s = i.substring(0, 2) == h;
            // n = t = s = 1
            return (n & t & s) === 1 || (n & t & s) === true;
        } catch (e) {
            console.log("screw you");
            return false;
        }
    })();
};

// Try reading my notes on this
// sctf{wh3r3_iz_mai_fooo0oood??}
