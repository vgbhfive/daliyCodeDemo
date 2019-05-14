from os import rename
import youtube_dl

def download(urls):
	ydl_opts = {
		'outtmpl': '%(title)s.%(ext)s'
	}

	with youtube_dl.YoutubeDL(ydl_opts) as ydl:
		for x in urls:
			print ([x])
			ydl.download([x])

if __name__ == '__main__':
	youtube_url = ['https://www.youtube.com/watch?v=0GBZibntFjU','https://www.youtube.com/watch?v=Nwg7SSaktUo','https://www.youtube.com/watch?v=hPOUNK9_fBo',
	'https://www.youtube.com/watch?v=aKB10WAyx5Y','https://www.youtube.com/watch?v=J3blMxorzjc','https://www.youtube.com/watch?v=P_iF5TG5zOk','https://www.youtube.com/watch?v=p31S8fZh1-M',
	'https://www.youtube.com/watch?v=vtvMKgRxt_A']
	download(youtube_url)