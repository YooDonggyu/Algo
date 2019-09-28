# BFS

+ 순회(traversal) : 그래프의 모든 노드들을 방문하는 일
+ 대표적인 두가지 방법
  + BFS
  + DFS

모든 노드들을 동심원 형태로 방문. 출발 노드가 필요(S노드)

> L0 = S(출발노드)
>
> L1 = L0의 모든 이웃 노드
>
> L2 = L1의 이웃들 중 L0에 속하지 않는 노드들
>
> ....
>
> Li = Li-1의 이웃들 중 Li-2에 속하지 않는 노드들



## 방법

1. 시작 노드를 확인
2. `Queue`를 활용
3. `배열`을 사용하여 방문한 노드는 체크
4. while
   + 큐에 노드가 있으면( q.size() > 0)
   + 큐에서 노드 꺼냄
     + for 꺼낸 노드 중 방문하지 않는 노드 중
       + 방문했다고 표시하고 큐에 넣기

```java
BFS(G,S)
    Q Declare
    Enqueue(Q, s)
    While Q != 0 do
        u <- Dequeue(Q)
        for each V adjacent to u do
            if v is unvisited then
            	mark v as visited
            	Enqueue(Q,V)
            end
        end
    end
```



## 최단경로

입력 : 방향 혹은 무방향 그래프, 출발노드

출력 : 모든 노드 v에 대해서

+ d[v] = s로부터 v까지의 최단 경로의 길이
+ p[v] = s로부터 v까지의 최단경로상에서 v의 직전 노드

```java
BFS(G,S)
    Q Declare
    d[s] <- 0
    p[s] <- null
    Enqueue(Q, s)
    While Q != 0 do
        u <- Dequeue(Q)
        for each V adjacent to u do
            if v is unvisited then
            	mark v as visited
            	d[v] <- d[u]+1
                p[v] <- u
            	Enqueue(Q,V)
            end
        end
    end
```



### BFS 트리

각 노드 v와 p[v]를 연결하는 Edge들로 구성된 트리

BFS 트리에서 s에서 v까지의 경로는 s에서 v까지의 최단경로



### 경로 출력

```java
PRINT-PATH(G, S, V)
    if v=s then
    	print s
    else if p[v] = null then
    	 print "no path from s to v exists"
    else
        PRINT-PATH(G,S,p[v])
        print v
    end
```



