import random

courses = ["410244","410245"]
electives= {"410244":["410244A","410244B","410244C","410244D"],"410245":["410245A","410245B","410245C","410245D"]}

cnt = 1
for i in range(481,721):
	for j in courses:
		temp = [1,2,3,4]
		for k in electives[j]:
			t = random.choice(temp)
			print("insert into student_pref values({0},\"{1}\",{2},\"{3}\",\"{4}\");".format(cnt,j,t,"stud"+str(i),k))
			cnt+=1
			temp.remove(t)

courses = ['510105']
electives = {'510105':['510105A','510105B','510105C','510105D','510105E']}

for i in range(721,801):
	for j in courses:
		temp = [1,2,3,4,5]
		for k in electives[j]:
			t = random.choice(temp)
			print("insert into student_pref values({0},\"{1}\",{2},\"{3}\",\"{4}\");".format(cnt,j,t,"stud"+str(i),k))
			cnt+=1
			temp.remove(t)

courses = ['610103']
electives = {'610103':['610103A','610103B','610103C','610103D','610103E']}

for i in range(241,321):
	for j in courses:
		temp = [1,2,3,4,5]
		for k in electives[j]:
			t = random.choice(temp)
			print("insert into student_pref values({0},\"{1}\",{2},\"{3}\",\"{4}\");".format(cnt,j,t,"stud"+str(i),k))
			cnt+=1
			temp.remove(t)
