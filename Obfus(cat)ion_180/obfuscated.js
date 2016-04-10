
// h3y th3r3. i kn0 ur pr0 h3xx0r c0z u f1nded mai s0urc3 c0de
// n0w pr0v3 ur 1337 h3xx0r by f1nd1ng mai fl4g!!11!
var _ = { 0x4c19cff: "random", 0x4728122: "charCodeAt", 0x2138878: "substring", 0x3ca9c7b: "toString", 0x574030a: "eval", 0x270aba9: "indexOf", 0x221201f: function(_9) { var _8 = []; for (var _a = 0, _b = _9.length; _a < _b; _a++) { _8.push(Number(_9.charCodeAt(_a)).toString(16)); } return "0x" + _8.join(""); }, 0x240cb06: function(_2, _3) { var _4 = Math.max(_2.length, _3.length); var _7 = _2 + _3; var _6 = ""; for(var _5=0; _5<_4; _5++) { _6 += _7.charAt((_2.charCodeAt(_5%_2.length) ^ _3.charCodeAt(_5%_3.length)) % _4); } return _6; }, 0x5c623d0: function(_c, _d) { var _e = ""; for(var _f=0; _f<_d; _f++) { _e += _c; } return _e; } };
var $ = [ 0x4c19cff, 0x3cfbd6c, 0xb3f970, 0x4b9257a, 0x1409cc7, 0x46e990e, 0x2138878, 0x1e1049, 0x164a1f9, 0x494c61f, 0x490f545, 0x51ecfcb, 0x4c7911a, 0x29f7b65, 0x4dde0e4, 0x49f889f, 0x5ebd02c, 0x556f342, 0x3f7f3f6, 0x11544aa, 0x53ed47d, 0x381f2118, 0x2e9d65d, 0x5c623d0, 0x32e8f8b, 0x3ca9c7b, 0x367a49b, 0x360179b, 0x5c862d6, 0x30dc1af, 0x7797d1, 0x221201f, 0x5eb4345, 0x5e9baad, 0x39b3b47, 0x32f0b8f, 0x48554de, 0x3e8b5e8, 0x5e4f31f, 0x48a53a6, 0x270aba9, 0x240cb06, 0x574030a, 0x1618f3a, 0x271259f, 0x3a306e5, 0x1d33b46, 0x17c29b5, 0x1cf02f4, 0xeb896b ];
var a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
function check() {
    var answer = document.getElementById("message").value;
        var correct = (function() {
            try {
                h = new MersenneTwister(parseInt(btoa(answer[_[$[6]]](0, 4)), 32));
                    e = h[_[$[""+ +[]]]]()*(""+{})[_[0x4728122]](0xc); for(var _1=0; _1<h.mti; _1++) { e ^= h.mt[_1]; }
                    l = new MersenneTwister(e);
                    l.random(); l.random(); l.random();
                    o = answer.split("_");
                    i = l.mt[~~(h.random()*$[0x1f])%0xff];
                    s = ["0x" + i[_[$[$.length/2]]](0x10), "0x" + e[_[$[$.length/2]]](0o20).split("-")[1]];
                    e =- (this[_[$[42]]](_[$[31]](o[1])) ^ s[0]); if (-e != $[21]) return false;
                    e ^= (this[_[$[42]]](_[$[31]](o[2])) ^ s[1]); if (-e != $[22]) return false; e -= 0x352c4a9b;
                    t = new MersenneTwister(Math.sqrt(-e));
                    h.random();
                    a = l.random();
                    t.random();
                    y = [ 0xb3f970, 0x4b9257a, 0x46e990e ].map(function(i) { return $[_[$[40]]](i)+ +1+ -1- +1; });
                    o[0] = o[0].substring(5); o[3] = o[3].substring(0, o[3].length - 1);
                    u = ~~~~~~~~~~~~~~~~(a * i);
                    a = parseInt(_[$[23]]("1", Math.max(o[0].length, o[3].length)), 3) ^ eval(_[$[31]](o[0]));
                    r = (h.random() * l.random() * t.random()) / (h.random() * l.random() * t.random());
                    e ^= ~r;
                    r = (h.random() / l.random() / t.random()) / (h.random() * l.random() * t.random());
                    e ^= ~~r;
                    a += _[$[31]](o[3].substring(o[3].length - 2)).split("x")[1];
                    d = parseInt(a, 16) == (Math.pow(2, 16)+ -5+ "") + o[3].charCodeAt(o[3].length - 3).toString(16) + "53846" + (new Date().getFullYear()- +1+ "");
                    i = 0xff;
                    n = (f = _[$[23]](o[3].charAt(o[3].length - 4), 3)) == o[3].substring(1, 4);
                    g = 111;
                    t = _[$[23]](o[3].charAt(3), 3) == o[3].substring(5, 8);
                    h = ((g ^ e ^ 96) & i).toString(16);
                    i = o[3].split(f).join("");
                    s = i.substring(0, 2) == h;
                    return (n & t & s) === 1 || (n & t & s) === true;
            } catch (e) {
                console.log("screw you");
                    return false;
            }
        })();
