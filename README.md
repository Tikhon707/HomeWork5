# HomeWork5 SQL
Домашка:

Cоздать контроллер, в котором:  
endpoint, который на вход будет принимать данные в виде:
<pre>
{  "name": "Мой список дел",  
  "events": ["дело1", "delo2", "delo3"]  } </pre>
валидировать их и сохранять в базу 


endpoint, который будет отдавать данные из бд в виде:
<pre>
[  
    {  
        "name": "Мой список дел",  
        "events": ["дело1", "delo2", "delo3"]  
    },  
    {  
        "name": "Мой список дел2",  
        "events": ["дело1", "delo2", "delo3"]  
    }  
]
</pre>
