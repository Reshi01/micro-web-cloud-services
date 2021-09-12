import 'dart:async';

import 'package:flutter/material.dart';
import 'package:front_taller_uno/model/paseo.dart';
import 'package:front_taller_uno/services/api_tours.dart';
import 'package:front_taller_uno/widgets/paseo_widget.dart';

import 'creation_screen.dart';

class Paseos extends StatefulWidget {
  @override
  _PaseosState createState() => _PaseosState();
}

class _PaseosState extends State<Paseos> {
  late Future<List<Paseo>> futureTutorships;

  var key = GlobalKey();

  @override
  void initState() {
    super.initState();
    futureTutorships = Api_tours().getPaseos();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Tutorías asignadas"),
      ),
      body: Container(
          child: FutureBuilder<List<Paseo>>(
              future: futureTutorships,
              builder: (context, snapshot) {
                if (snapshot.hasData) {
                  return ListView.builder(
                      key: key,
                      itemCount: snapshot.data!.length,
                      itemBuilder: (context, index) {
                        var paseo = snapshot.data![index];
                        return Dismissible(
                          // Each Dismissible must contain a Key. Keys allow Flutter to
                          // uniquely identify widgets.
                          key: Key(paseo.id),
                          // Provide a function that tells the app
                          // what to do after an item has been swiped away.
                          onDismissed: (direction) {
                            // Remove the item from the data source.
                            setState(() {
                              snapshot.data!.removeAt(index);
                            });
                            // Then show a snackbar.
                            ScaffoldMessenger.of(context).showSnackBar(
                                SnackBar(content: Text('dismissed')));
                          },
                          child: Center(
                            child: Padding(
                              padding: const EdgeInsets.all(20.0),
                              child: Paseo_widget(paseo: paseo),
                            ),
                          ),
                        );
                      });
                } else {
                  return Center(child: CircularProgressIndicator());
                }
              })),
      floatingActionButton: FloatingActionButton(
        onPressed: _addTour,
        tooltip: 'Agregar',
        child: Icon(Icons.add),
      ),
    );
  }

  

  void _addTour() {
     Route route = MaterialPageRoute(builder: (context) => Creation_screen());
    Navigator.push(context, route).then((value) => setState(() {}));
  }
}
