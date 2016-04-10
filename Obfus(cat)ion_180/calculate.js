// Calculate the correct character that will make d valid
// We know that parseInt(a, 16) will only return a number in base 10, so let's brute force the last 2 chars, which is
// a += _[$[31]](o[3].substring(o[3].length - 2)).split("x")[1];
for (var i = 0; i < 0xff; i++) {
    var tmp = "65531" + i + "538462015";
    hex = parseInt(tmp).toString(16);
    last = hex.substring(hex.length-4);
    first = String.fromCharCode(parseInt(last.substring(0, 2), 16));
    second = String.fromCharCode(parseInt(last.substring(2), 16));
    combined = first + second;
    a = hex.substring(0, hex.length-4);
    a = a.replace(/[^0-9]/gi, "");
    if (a.length == hex.length-4) {
        console.log(combined + "=" + a + "+" + last);
        console.log(i);
    }
}

// Let's ride on the fact that ?? seems the most legit for the last characters
// for (var i = 0; i < 20; i++) {
//     xor = parseInt(_[$[23]]("1", i), 3) ^ 1748118478;
//     console.log(parseInt(xor).toString(16));
//     firstChar = parseInt(xor).toString(16).substring(0, 2);
// }
// This doesn't work, but
// Playing around with the o[3] gives us that "wh3r3" will make d true
