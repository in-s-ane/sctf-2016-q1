from PIL import Image
import re
import socket

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

RED = (255, 0, 0)
PURPLE = (128, 0, 128)
BLUE = (0, 0, 255)
GREEN = (0, 128, 0)
YELLOW = (255, 255, 0)
ORANGE = (255, 165, 0)

shifts = [RED, PURPLE, BLUE, GREEN, YELLOW, ORANGE]

def decrypt(image):
    image = Image.open(image)
    pixels = image.load()
    width, height = image.size

    dec = ""

    for y in range(0, height, 12):
        color = pixels[0, y]
        binary = ""
        for x in range(1, 8)[::-1]:
            px = pixels[width-x*12, y]
            binary += ["0", "1"][px == BLACK]

        shift = shifts.index(color)
        decimal = int(binary, 2)
        dec += chr(decimal-shift)

    return dec

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.settimeout(1)
sock.connect(("problems1.2016q1.sctf.io", 50000))
while True:
    data = ""
    while True:
        try:
            part = sock.recv(4096)
            data += part
        except:
            break
    if "INCORRECT" in part or "sctf" in part or "FLAG" in part:
        break

    print data

    b64 = re.findall(r"'*base64,([^']*)'", data)[0]
    open("tmp.png", "w").write(b64.decode("base64"))
    dec = decrypt("tmp.png")
    sock.send(dec)

# sctf{y0ub34tth3v3rt1c0d3}
