//
//  ViewController.swift
//  AppCalculator
//
//  Created by Adalto Selau Sparremberger on 05/08/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var txtValor: UITextField!
    
    @IBOutlet weak var lblResultado: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    @IBAction func calcular(_ sender: Any) {
        
//        let sValor = txtValor.text
//        let valor = Double( sValor! )
            
        if let sValor = txtValor.text {
            if let valor = Double( sValor ){
                let result = valor * 2
                lblResultado.text = String( result )
            }
        }
        
        
        
    }
    
}

