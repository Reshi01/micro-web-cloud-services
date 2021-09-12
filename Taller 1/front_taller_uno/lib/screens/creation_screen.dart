// Create a Form widget.
import 'package:flutter/material.dart';
import 'package:front_taller_uno/services/api_tours.dart';

class Creation_screen extends StatefulWidget {
  @override
  Creation_screenState createState() {
    return Creation_screenState();
  }
}

// Create a corresponding State class. This class holds data related to the form.
class Creation_screenState extends State<Creation_screen> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  DateTime selectedDate = DateTime.now();
  String _name = '';
  String _inicio = '';
  String _fin = '';
  final _formKey = GlobalKey<FormState>();
  final myController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey created above.
    return Scaffold(
        appBar: AppBar(
          title: Text("Crear paseo"),
        ),
        body: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              TextFormField(
                decoration: const InputDecoration(
                  icon: const Icon(Icons.card_travel_rounded),
                  hintText: 'Nombre',
                  labelText: 'Nombre',
                ),
              ),
              TextFormField(
                decoration: const InputDecoration(
                  icon: const Icon(Icons.location_pin),
                  hintText: 'Inicio',
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
                decoration: const InputDecoration(
                  icon: const Icon(Icons.location_pin),
                  hintText: 'Destino',
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
              Center(
                child: Column(
                mainAxisSize: MainAxisSize.min,
                children: <Widget>[
                  SizedBox(
                    height: 20.0,
                  ),
                  Text(
                    "${selectedDate.toLocal()}".split(' ')[0],
                    style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
                  ),
                  SizedBox(
                    height: 20.0,
                  ),
                  ElevatedButton(
                    onPressed: () => _selectDate(context), // Refer step 3
                    child: Text(
                      'Selecciona una fecha',
                      style: TextStyle(
                          color: Colors.white, fontWeight: FontWeight.bold),
                    ),
                  ),
                ],
              ),
              ),
              
              new Container(
                  
                  child: Center(
                    child: new ElevatedButton(
                      child: const Text('Crear'),
                      onPressed: () {
                        // Validate will return true if the form is valid, or false if
                        // the form is invalid.
                        if (_formKey.currentState!.validate()) {
                          crear();
                          
                        }
                      },
                    ),
                  )),
            ],
          ),
        ));
  }

  _selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: selectedDate, // Refer step 1
      firstDate: DateTime(2000),
      lastDate: DateTime(2025),
    );
    if (picked != null && picked != selectedDate)
      setState(() {
        selectedDate = picked;
      });
  }

  void crear() {
    Api_tours().postPaseo(_name, selectedDate.toString(), _inicio, _fin);
    //Navigator.pop(context);
  }
}
