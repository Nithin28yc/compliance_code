from mongo import col
import re

pat = re.compile(r"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")

def test_validate_data():

    for doc in col.find():
        re.fullmatch(pat, doc["password"])
