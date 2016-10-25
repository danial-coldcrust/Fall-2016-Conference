import pygame
import random
from socket import *
from threading import*
white    = ( 255, 255, 255)
rcolor = (random.randrange(255),random.randrange(255),random.randrange(255))

class Circle(pygame.sprite.Sprite):
    width = 20
    height = 20
    def __init__(self, color):
        pygame.sprite.Sprite.__init__(self)
   
        self.image = pygame.Surface([self.width, self.height])
        self.image.fill(white)
        self.image.set_colorkey(white)
        pygame.draw.ellipse(self.image,color,[0,0,self.width,self.height])
        self.rect = self.image.get_rect()
        # 화면 움직이기 
        self.rect.x = 320
        self.rect.y = 240
        self.x = 320
        self.y = 240
        self.scrollX = 0
        self.scrollX_speed = 0
        self.scrollY = 0
        self.scrollY_speed = 0        
        
        
    def sizechange(self, width, height,pos1,pos2):
        pygame.sprite.Sprite.__init__(self)
        self.image = pygame.Surface([width, height])
        self.image.fill(white)
        self.image.set_colorkey(white)
        pygame.draw.ellipse(self.image,rcolor,[0,0,width,height])
        self.rect = self.image.get_rect(center=(-5000,-5000))        

    def update(self):
        pos = pygame.mouse.get_pos()
        self.x  = pos[0]
        self.y = pos[1]
        # 3시 방향
        if self.x   > 590 and self.x < 600:
            self.scrollX -= self.scrollX_speed
            if self.scrollX  - 600 <= -1080:
                self.scrollX_speed = 0
                
            else:
                self.scrollX_speed = 1
                for i in range(len(List)):
                    List[i].rect.x -= 1
                    List[i].x -= 1
        # 6시 방향
        if self.y  > 470 and self.y < 480:
            self.scrollY -= self.scrollY_speed
            if self.scrollY- 480 <= -889:
                self.scrollY_speed = 0
            else:
                self.scrollY_speed = 1
                for i in range(len(List)):
                    List[i].rect.y -= 1
                    List[i].y -=1
        # 9시 방
        if (self.x  > 0 and self.x  < 30):
            self.scrollX += self.scrollX_speed
            if self.scrollX  >= 0:
                self.scrollX_speed = 0
            else:
                self.scrollX_speed = 1
                for i in range(len(List)):
                    List[i].rect.x += 1
                    List[i].x += 1
                    
        # 12시 방
        if (self.y> 0 and self.y< 30):
            self.scrollY += self.scrollY_speed
            if self.scrollY >= 0:
                self.scrollY_speed = 0
            else:
                self.scrollY_speed = 1
                for i in range(len(List)):
                    List[i].rect.y += 1
                    List[i].y +=1
        self.rect.x = self.x
        self.rect.y = self.y
        #screen.blit(self.image, (self.x, self.y))
        #all_sprites_list.clear(screen, screen.blit)
        

List = []
def 생성(x5,y5):
    for i in range(50):
        rcolor = (random.randrange(254),random.randrange(254),random.randrange(254))
        circle = Circle(rcolor)
        circle.rect.x = random.randrange(x5)
        circle.rect.y = random.randrange(y5)            
        Circle_list.add(circle)
        all_sprites_list.add(circle)
        List.append(circle)
        
pygame.init()
screen_width=600
screen_height=480
pygame.display.set_caption("우뭇가사리")
screen=pygame.display.set_mode([screen_width,screen_height])
bg = pygame.image.load("map.bmp").convert()
Circle_list = pygame.sprite.RenderPlain()
all_sprites_list = pygame.sprite.RenderPlain()

clock=pygame.time.Clock()
done=False
time = 0

serverName = '192.168.14.101'
serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)


while done==False:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            done=True

    connectionSocket, addr = serverSocket.accept()
    messge = connectionSocket.recv(1024)
    print ("x, y : " , messge)
    connectionSocket.send(messge)
    connectionSocket.close()
    screen.fill(white)
    if time == 600:
        생성(1080-20,889-20)
        time = 0   
    all_sprites_list.draw(screen)
    clock.tick(30)
    pygame.display.flip()
    time +=1
    print("현재 타임은 ", time)

pygame.quit()
