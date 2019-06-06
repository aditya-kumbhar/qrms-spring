# +-------------+--------------+------+-----+---------+-------+
# | Field       | Type         | Null | Key | Default | Extra |
# +-------------+--------------+------+-----+---------+-------+
# | id          | int(11)      | NO   | PRI | NULL    |       |
# | course_exp  | int(11)      | YES  |     | NULL    |       |
# | course_id   | varchar(255) | YES  |     | NULL    |       |
# | elective_id | varchar(255) | YES  |     | NULL    |       |
# | pref_no     | int(11)      | YES  |     | NULL    |       |
# | prereq1_exp | int(11)      | YES  |     | NULL    |       |
# | prereq2_exp | int(11)      | YES  |     | NULL    |       |
# | user_name   | varchar(255) | YES  |     | NULL    |       |
# | year        | varchar(255) | YES  |     | NULL    |       |
# +-------------+--------------+------+-----+---------+-------+
import pandas as pd
df = pd.read_excel('ok.xlsx',dtype={'course':str,'year':str,'facID':str})
# df_list = pd.read_html('ok.xlsx')
# df = pd.DataFrame(df_list[0])
for index,row in df.iterrows():
    if('A' in row['course'] or 'B' in row['course'] or 'C' in row['course'] or 'D' in row['course']):
        print("INSERT INTO faculty_pref values({},{},null,'{}',{},{},{},'{}','{}');".format(index,row['exp'],row['course'],row['pref_no'],row['pr1_exp'],row['pr2_exp'],row['facID'],row['year']))
    else:
        print("INSERT INTO faculty_pref values({},{},'{}',null,{},{},{},'{}','{}');".format(index,row['exp'],row['course'],row['pref_no'],row['pr1_exp'],row['pr2_exp'],row['facID'],row['year']))
