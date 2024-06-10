import pymongo

myclient=pymongo.MongoClient("mongodb://localhost:27017")

db_list=myclient.list_database_names()
print(db_list)

db=myclient["harshitha"]
col=db["demo"]

# document1={"Name":"Raj","Roll No ":  153,"Branch ": "CSE","password":"Harshitha123"}
# col.insert_one(document1)
#
# documents1=[{"Name":"Roshan","Roll No":159,"Branch":"CSE","password":"Harshi"},
#            {"Name":"Rahim","Roll No":155,"Branch":"CSE","password":"Harshi@123"},
#             {"Name":"Ronak","Roll No":156,"Branch":"CSE","password":"Harshi123"}]
# col.insert_many(documents1)

# my_list=[]
# for doc in col.find():
#     my_list.append(doc)
#     print(doc)
#
# print(my_list)
#
# def data_array(my_list):
#     return my_list
#
# list=data_array(my_list)
# print(list)
