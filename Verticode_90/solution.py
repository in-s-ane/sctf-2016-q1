from PIL import Image

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

RED = (255, 0, 0)
PURPLE = (128, 0, 128)
BLUE = (0, 0, 255)
GREEN = (0, 128, 0)
YELLOW = (255, 255, 0)
ORANGE = (255, 165, 0)

shifts = [RED, PURPLE, BLUE, GREEN, YELLOW, ORANGE]

image = Image.open("code1.png")
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

print dec

# sctf{iamtheflagalllowercasenojoke}
