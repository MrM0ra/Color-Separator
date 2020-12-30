class Person:
	
	def __init__(self, name, email, pwd, age):
		self.name=name
		self.email=email
		self.pwd=pwd
		self.age=age

	def setName(self, name):
		self.name=name

	def setEmail(self, email):
		self.email=email
	
	def setPwd(self, pwd):
		self.pwd=pwd
	
	def setAge(self, age):
		self.age=age
	
	def introduce(self):
		print("Hi, my name is {} and i'm {} y/o".format(self.name, self.age))

	def introduce2(self):
		element=("Hi, my name is {} and i'm {} y/o".format(self.name, self.age))
		return element