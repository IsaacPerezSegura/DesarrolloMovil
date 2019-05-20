<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Propietario extends Model
{
    //
	protected $fillable = ['nombre'];
	protected $table = 'propietario';
	
	public function laptop(){
		return $this->hasMany('App/Laptop','idPropietario');
	}
}
