be = ['410250','410251','410251','410252B','410252C','410252D','410253B','410253C']
te = ['310250','310251','310252','310253','310254']
se = ['210251','210252','210253','210254']
excluded_courses = ['410252C','310252','210252']
import random as r
# for i in range(36):

# 	#print BE
# 	k = r.randint(0,len(be)-1)
# 	while(be[k] in excluded_courses):
# 		k = r.randint(0,len(be)-1)
# 	printed = be[k]
# 	print(printed)
# 	k = r.randint(0,len(be)-1)
# 	while(be[k] in excluded_courses or be[k]==printed):
# 		k = r.randint(0,len(be)-1)
# 	print(be[k])
	
# 	#print TE
# 	k = r.randint(0,len(te)-1)
# 	while(te[k] in excluded_courses):
# 		k = r.randint(0,len(te)-1)
# 	printed = te[k]
# 	print(printed)
# 	k = r.randint(0,len(te)-1)
# 	while(te[k] in excluded_courses or te[k]==printed):
# 		k = r.randint(0,len(te)-1)
# 	print(te[k])
	
# 	#print SE
# 	k = r.randint(0,len(se)-1)
# 	while(se[k] in excluded_courses):
# 		k = r.randint(0,len(se)-1)
# 	printed = se[k]
# 	print(printed)
# 	k = r.randint(0,len(se)-1)
# 	while(se[k] in excluded_courses or se[k]==printed):
# 		k = r.randint(0,len(se)-1)
# 	print(se[k])


## Experience print
# for i in range(36*6):
# 	k = r.randint(0,8)
# 	print(k)


###PREF NO Print
for i in range(36):
	li=[]
	for i in range(6):
		k = r.randint(1,6)
		while k in li:
			k = r.randint(1,6)
		li.append(k)
		print(k)