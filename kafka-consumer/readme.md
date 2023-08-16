Ce projet est une demo pour utiliser Kafka. <br>
<strong> Producer </strong> : permet d'envoyer des informations à un broker kafka <br><br>
<strong> Topics </strong> : les informations envoyées au broker kafka sont ajouté à un topic sur lequel un consumer va se baser plutard pour recuperer les messages.<br><br>
<strong> Partitions </strong> : On peut subdiviser un topic en plusieurs partitions afin d'assurer la haute disponibilité. <br><br>
<strong> offset </strong> : numero attribué à chaque message sur lequel va se baser le consumer pour la recuperation.il est très utilite pour la reprise d'activité en cas de panne du consumer .<br><br>
<strong> Consumer </strong> : Permet de recuperer les messages stockés dans le topic d'un broker kafka.<br><br>
<strong> GroupId </strong> : Les consumers doivent etre generalement crées et ajouter dans un groupe via la notion de groupId .<br><br>
Le nombre de consumer dans un group doit correspondre au nombre de partition du topic ou les consumers doivent recuperer le message + 1 ,utilise pour le rebalacing (Cas de perte d'un consumer).


