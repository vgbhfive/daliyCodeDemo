import os

for file in os.listdir('.'): #当前目录下的文件或特殊目录下的文件
	if file[-2:] == 'py': # 避免误删当前目录下的py文件
		continue
	new_name = file.file.replace(' ', '').replace(' ', '') # 去掉空格和特殊字符
	os.rename(file, new_name)