import pymongo
import re

# compiling the pattern for alphanumeric string
pat = re.compile(r"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")

myclinet = pymongo.MongoClinet("url")

db_list=myclient.list_database_names()
print(db_list)
db=myclient["cloveDb"]
#we are not allowed to print the collection names that is why below command wont work
# print(db.list_collection_names())
col=db["demo"]
col_validate=db["password"]

#to insert single doc
document1={"Name":"Raj","Roll No ":  153,"Branch ": "CSE","password":"Harshitha123"}
col_validate.insert_one(document1)

#to insert multiple documents
documents1=[{"Name":"Roshan","Roll No":159,"Branch":"CSE","password":"Harshi"},
           {"Name":"Rahim","Roll No":155,"Branch":"CSE","password":"Harshi@123"},
            {"Name":"Ronak","Roll No":156,"Branch":"CSE","password":"Harshi123"}]
col_validate.insert_many(documents1)
##
#to print the documents of the particular collection
for doc in col_validate.find():
    
    if re.fullmatch(pat, doc["password"]):
       print("correct")
    else:
        print("incorrect")


#to insert one document
# document={"Name":"Raj",
# "Roll No ":  153,
# "Branch ": "CSE"}
# col.insert_one(document)

#to insert multiple documents
# documents=[{"Name":"Roshan","Roll No":159,"Branch":"CSE"},{"Name":"Rahim","Roll No":155,"Branch":"CSE"},{"Name":"Ronak","Roll No":156,"Branch":"CSE"}]
# col.insert_many(documents)

#retrieving a single document from the collection and will return first hit document
# query={"Name":"Raj"}
# print(col.find_one(query))

# #retrieving multiple documents from the collection
# query={"Branch":"CSE"}
# result=col.find(query)
# for i in result:
#     print(i)

# # #To retrieve all the documents you need to pass an empty query into the find method.
# # #If we want to limit the number of documents to be retrieved then we use limit() method.
# result=col.find({}).limit(2)
# for i in result:
#     print(i)

# # #updating multiple document
# present_data={"Branch":"CSE"}
# new_data={"$set":{"Branch":"ECE"}}
# col.update_many(present_data,new_data)


#delete a single document
# query={"Roll No":153}
# col.delete_one(query)

# #to delete multiple documents
# query={"Branch":"CSE"}
# col.delete_many(query)

#to drop collection from data base
#col.drop()

#to print the documents of the particular collection
# for doc in col.find():
#     print(doc)
