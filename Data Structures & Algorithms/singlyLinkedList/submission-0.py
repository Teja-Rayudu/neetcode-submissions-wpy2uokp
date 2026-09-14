class Node:
    def __init__(self,val: int):
        self.val = val
        self.next = None

class LinkedList:

    def __init__(self):
        self.head = None
    
    def get(self, index: int) -> int:
        
        curr = self.head
        pointer = 0
        while curr is not None:
            if pointer == index:
                return curr.val
            curr = curr.next
            pointer += 1
        
        return -1

    def insertHead(self, val: int) -> None:
        if self.head is None:
            self.head = Node(val)
            return
        
        curr_node = Node(val)
        curr_node.next = self.head
        self.head = curr_node

    def insertTail(self, val: int) -> None:
        new_node = Node(val)
        if self.head is None:
            self.head = new_node
            return
        
        curr = self.head
        while curr.next != None:
            curr = curr.next
        
        curr.next = new_node

    def remove(self, index: int) -> bool:
        if self.head is None:
            return False
        
        if index == 0:
            self.head = self.head.next
            return True
        
        curr = self.head
        prev = None
        pointer = 0

        while curr != None:
            if(pointer == index):
                prev.next = curr.next
                return True
            
            pointer += 1
            prev = curr
            curr = curr.next
        
        return False
        

    def getValues(self) -> List[int]:
        lst = []

        if self.head is None:
            return lst
        
        curr = self.head

        while curr is not None:
            lst.append(curr.val)
            curr = curr.next
        
        return lst
