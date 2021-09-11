
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:front_taller_uno/model/paseo.dart';
import 'package:intl/intl.dart';

class Paseo_widget extends StatelessWidget{
  final Paseo paseo;
 

  Paseo_widget({required this.paseo});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Card(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            ListTile(
              leading: Icon(Icons.class__rounded),
              title: Text(
                paseo.name,
                overflow: TextOverflow.ellipsis,
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              
              subtitle: Text('Codigo: ' + paseo.name),
            ),
            const SizedBox(width: 8),
            Text(
              'Fecha: ' + DateFormat.yMMMMd('en_US').format(paseo.tourDate),
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            Text(
              'Hora: ' + DateFormat.jm().format(paseo.tourDate),
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            Text(
              'Lugar de inicio: ' + paseo.start.toString(),
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            Text(
              'Lugar de inicio: ' + paseo.finish.toString(),
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            const SizedBox(width: 8),
            const Divider(
              color: Colors.amber,
              height: 20,
              thickness: 5,
              indent: 20,
              endIndent: 20,
            ),
            
           
          ],
        ),
      ),
    );
  }
}