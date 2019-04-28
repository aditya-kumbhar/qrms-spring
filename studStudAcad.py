import random

for i in range(1,81):
	print("insert into student_acad values(\"{0}\",{1},\"{2}\",{3},{4},\"{5}\",\"{6}\",\"{7}\",\"{8}\");".format("stud"+str(320+i),round(random.uniform(50,100), 2),str(i),4,1,"ME2","CO","ME2COA","stud"+str(320+i)))

for i in range(1,81):
	print("insert into student_acad values(\"{0}\",{1},\"{2}\",{3},{4},\"{5}\",\"{6}\",\"{7}\",\"{8}\");".format("stud"+str(240+i),round(random.uniform(50,100), 2),str(i),2,1,"ME1","CO","ME1COA","stud"+str(240+i)))

for i in range(1,81):
	print("insert into student_acad values(\"{0}\",{1},\"{2}\",{3},{4},\"{5}\",\"{6}\",\"{7}\",\"{8}\");".format("stud"+str(160+i),round(random.uniform(50,100), 2),str(i),8,2,"BE","CO","BECOC","stud"+str(160+i)))

for i in range(1,81):
	print("insert into student_acad values(\"{0}\",{1},\"{2}\",{3},{4},\"{5}\",\"{6}\",\"{7}\",\"{8}\");".format("stud"+str(80+i),round(random.uniform(50,100), 2),str(i),8,1,"BE","CO","BECOB","stud"+str(80+i)))

for i in range(1,81):
	print("insert into student_acad values(\"{0}\",{1},\"{2}\",{3},{4},\"{5}\",\"{6}\",\"{7}\",\"{8}\");".format("stud"+str(0+i),round(random.uniform(50,100), 2),str(i),8,1,"BE","CO","BECOA","stud"+str(0+i)))
