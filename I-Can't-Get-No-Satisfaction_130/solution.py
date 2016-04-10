from z3 import *
import requests

class Infix:
    def __init__(self, function):
        self.function = function
    def __ror__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __or__(self, other):
        return self.function(other)
    def __rlshift__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __rshift__(self, other):
        return self.function(other)
    def __call__(self, value1, value2):
        return self.function(value1, value2)

_or_=Infix(lambda x,y: Or(x, y))
_and_=Infix(lambda x,y: And(x, y))
implies=Infix(lambda x,y: Or(Not(x), y))
implies_not=Infix(lambda x,y: Or(Not(x), Not(y)))

a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z = Bools("a b c d e f g h i j k l m n o p q r s t u v w x y z")
solver = Solver()
fin = open("simplified.prop","r").read().strip()
solver.add(eval(fin))

print solver.check()
m = solver.model()
print m

data = {
    "a": "false",
    "b": "false",
    "c": "false",
    "d" : "true",
    "e": "true",
    "f": "true",
    "g": "false",
    "h": "false",
    "i": "false",
    "j": "false",
    "k": "true",
    "l": "true",
    "m": "true",
    "n": "true",
    "o": "true",
    "p": "true",
    "q": "true",
    "r": "true",
    "s": "false",
    "t": "false",
    "u": "true",
    "v": "true",
    "w": "false",
    "x": "false",
    "y": "true",
    "z": "false"
}

response = requests.get("http://problems3.2016q1.sctf.io:11420/", data=data).text
print response

# Accidentally going to http://problems3.2016q1.sctf.io:11420/?a=true&b=true&c=true reveals the flag.
# For some reason the z3 program doesn't work, but hey, we take those.
# sctf{TOO_sat_FOR_you}
