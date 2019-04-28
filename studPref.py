import random

courses = ["410252","410253"]
electives= {"410252":["410252A","410252B","410252C","410252D"],"410253":["410253A","410253B","410253C","410253D"]}

cnt = 1
for i in range(1,241):
	for j in courses:
		temp = [1,2,3,4]
		for k in electives[j]:
			t = random.choice(temp)
			print("insert into student_pref values({0},\"{1}\",{2},\"{3}\",\"{4}\");".format(cnt,j,t,"stud"+str(i),k))
			cnt+=1
			temp.remove(t)

courses = ['510110']
electives = {'510110':['510110A','510110B','510110C','510110D','510110E']}

for i in range(241,321):
	for j in courses:
		temp = [1,2,3,4,5]
		for k in electives[j]:
			t = random.choice(temp)
			print("insert into student_pref values({0},\"{1}\",{2},\"{3}\",\"{4}\");".format(cnt,j,t,"stud"+str(i),k))
			cnt+=1
			temp.remove(t)
'''
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
'''
