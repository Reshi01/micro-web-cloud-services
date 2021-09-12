import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:front_taller_uno/model/paseo.dart';
import 'package:front_taller_uno/services/api_tours.dart';
import 'package:intl/intl.dart';

class Paseo_widget extends StatelessWidget {
  final Paseo paseo;
  String _inicio = '';
  String _fin = '';
  final _formKey = GlobalKey<FormState>();

  Paseo_widget({required this.paseo,
  });


  @override
  Widget build(BuildContext context) {
    return Container(
      child: Card(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            ListTile(
              leading: Icon(Icons.travel_explore_rounded),
              title: Text(
                paseo.name,
                overflow: TextOverflow.ellipsis,
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              
            ),
            const SizedBox(width: 8),
            Text(
              'Fecha: ' + paseo.tourDate,
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
            Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  
                  TextFormField(
                    initialValue: paseo.start,
                    decoration:  InputDecoration(
                      icon: const Icon(Icons.location_pin),
                      
                      hintText: 'Lugar de inicio: ',
                      labelText: 'Inicio',
                    ),
                    validator: (String? value) {
                      if (value == null || value.isEmpty) {
                        return 'Ingresa un valor';
                      }
                      _inicio = value;
                      return null;
                    },
                  ),
                  TextFormField(
                    initialValue: paseo.finish,
                    decoration: InputDecoration(
                      icon: const Icon(Icons.location_pin),
                      hintText: 'Lugar final: ',
                      labelText: 'Fin',
                    ),
                    validator: (String? value) {
                      if (value == null || value.isEmpty) {
                        return 'Ingresa un valor';
                      }
                      _fin = value;
                      return null;
                    },
                  ),
                  
                  new Container(
                      padding: const EdgeInsets.only(left: 150.0, top: 40.0),
                      child: new ElevatedButton(
                        child: const Text('Actualizar ruta'),
                        onPressed: () {
                          // Validate will return true if the form is valid, or false if
                          // the form is invalid.
                          if (_formKey.currentState!.validate()) {
                            actualizar(paseo.id);
                            Navigator.pop(context);
                          }
                        },
                      )),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  void actualizar(String id) {
    Api_tours().modifyPath(_inicio, _fin, id);
  }
}
