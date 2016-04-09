enc = open("encrypted.dat", "r").read().strip().split(", ")
print "".join([chr(len(x)) for x in enc])

# sctf{101_th3_numb3r5_d1dn'7_3v3n_m4tt3r}
