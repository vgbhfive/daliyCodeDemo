from twilio.rest import Client

# 注册twilio给你的账户Id和Token
account_id = "ACxxxxx"
account_token = "xxxxxxxxxxx"

client = Client(account_id, account_token)

message = client.messages.
					create(to="+86xxxxxxxxxxx", # 要发送的电话号码
						from_="+xxxxxxxxxxx", # twilio给你的电话号码
						body="At first sight, love at the second sight, and never give up. " # 发送的内容
						)

print(message.sid)