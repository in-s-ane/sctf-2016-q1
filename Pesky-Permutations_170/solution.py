import pycuber as pc

formulas = open("perms.dat", "r").readlines()
formulas = map(str.strip, formulas)

perms = []

solved = pc.Cube()
num = 1
for formula in formulas:
    perm = 1
    cube = pc.Cube()
    cube(formula)
    while cube != solved:
        cube(formula)
        perm += 1
    print "Solved cube %s" % num
    perms.append(perm)
    num += 1

print "{0:.2f}".format(reduce(lambda x, y: x + y, perms) / (len(perms) * 1.0))
print perms

# 140.13
