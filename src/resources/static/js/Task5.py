import pandas as pd

df = pd.read_csv("your_dataset.csv")  # Change to your file name
df.head()
df.info()
df.describe()
df.isnull().sum()
df.nunique()
