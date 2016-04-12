f = open("compressed.zip", "rb").read().strip()

JFIF = "\x4a\x46\x49\x46"

count = 0
while JFIF in f:
	start = f.find(JFIF)
	end = f.find("\xff\xd9")
	open("%s.jpg" % count, "w").write("\xff\xd8\xff\xe0\x00\x10" + f[start:end+2])
	f = f[end+2:]
	count += 1

# Binwalk is useless here, since all the photos inside the zip have their first few bytes missing
# This script walks through the zip file, and repairs and extracts the jpgs.

# The flag is in 330.jpg
# sctf{1_am_50_50rry_4_d01ng_thi5_2_u}