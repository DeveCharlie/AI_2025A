;; --- Templates ---
(deftemplate symptoma
   (slot nombre))

(deftemplate diagnostico
    (slot nombre))

(deftemplate medicamento
    (slot nombre))

(deftemplate observacion
    (slot nombre))

;; --- Reglas de enfermedades comunes ---

(defrule influenza
   (symptoma (nombre fiebre))
   (symptoma (nombre tos))
   (symptoma (nombre dolor_cabeza))
   (symptoma (nombre dolor_articular))
   =>
   (printout t "Diagnostico: Influenza (gripe)" crlf)
   (printout t "Receta: Oseltamivir y Paracetamol" crlf)
   (printout t "observacion: Reposo absoluto, tomar liquidos, y evitar cambios de temperatura" crlf)
   (assert (diagnostico (nombre influenza)))
   (assert (medicamento (nombre Oseltamivir)))
   (assert (medicamento (nombre Paracetamol)))
   (assert (observacion (nombre "Reposo absoluto")))
   (assert (observacion (nombre "Tomar liquidos")))
   (assert (observacion (nombre "Evitar cambios de temperatura"))))

(defrule covid
   (symptoma (nombre fiebre))
   (symptoma (nombre tos))
   (symptoma (nombre dificultad_respirar))
   (symptoma (nombre perdida_olfato))
   =>
   (printout t "Diagnostico: COVID-19" crlf)
   (printout t "Receta: Paracetamol, oxigeno si es necesario, y aislamiento" crlf)
   (printout t "observacion: Aislamiento, uso de cubrebocas, y monitoreo de oxigenacion" crlf)
   (assert (diagnostico (nombre covid)))
   (assert (medicamento (nombre Paracetamol)))
   (assert (observacion (nombre Aislamiento)))
   (assert (observacion (nombre "Uso de cubrebocas")))
   (assert (observacion (nombre "Monitorear oxigenacion"))))

(defrule migrania
   (symptoma (nombre dolor_cabeza))
   (symptoma (nombre nauseas))
   =>
   (printout t "Diagnostico: Migrania" crlf)
   (printout t "Receta: Ibuprofeno o sumatriptan" crlf)
   (printout t "observacion: Evitar luz fuerte y descansar en un ambiente tranquilo" crlf)
   (assert (diagnostico (nombre migrania)))
   (assert (medicamento (nombre Ibuprofeno)))
   (assert (medicamento (nombre Sumatriptan)))
   (assert (observacion (nombre "Evitar luz fuerte")))
   (assert (observacion (nombre "Descansar en ambiente tranquilo"))))

(defrule gastroenteritis
   (symptoma (nombre dolor_abdominal))
   (symptoma (nombre vomito))
   (symptoma (nombre diarrea))
   =>
   (printout t "Diagnostico: Gastroenteritis" crlf)
   (printout t "Receta: Suero oral, paracetamol, y dieta blanda" crlf)
   (printout t "observacion: Hidratarse constantemente y evitar alimentos grasos" crlf)
   (assert (diagnostico (nombre gastroenteritis)))
   (assert (medicamento (nombre "Suero oral")))
   (assert (medicamento (nombre Paracetamol)))
   (assert (observacion (nombre "Hidratarse constantemente")))
   (assert (observacion (nombre "Evitar alimentos grasos"))))

(defrule dengue
   (symptoma (nombre fiebre))
   (symptoma (nombre dolor_cabeza))
   (symptoma (nombre dolor_articular))
   =>
   (printout t "Diagnostico: Dengue" crlf)
   (printout t "Receta: Paracetamol y liquidos en abundancia" crlf)
   (printout t "observacion: No tomar aspirina y acudir a revision medica" crlf)
   (assert (diagnostico (nombre dengue)))
   (assert (medicamento (nombre Paracetamol)))
   (assert (observacion (nombre "Tomar abundantes liquidos")))
   (assert (observacion (nombre "Evitar aspirina")))
   (assert (observacion (nombre "Acudir a revision medica"))))

(defrule faringitis
   (symptoma (nombre dolor_garganta))
   (symptoma (nombre fiebre))
   =>
   (printout t "Diagnostico: Faringitis" crlf)
   (printout t "Receta: Ibuprofeno o Amoxicilina (si es bacteriana)" crlf)
   (printout t "observacion: Tomar liquidos tibios y evitar hablar mucho" crlf)
   (assert (diagnostico (nombre faringitis)))
   (assert (medicamento (nombre Ibuprofeno)))
   (assert (medicamento (nombre Amoxicilina)))
   (assert (observacion (nombre "Tomar liquidos tibios")))
   (assert (observacion (nombre "Evitar hablar mucho"))))

(defrule sinusitis
   (symptoma (nombre dolor_cabeza))
   (symptoma (nombre escurrimiento_nasal))
   =>
   (printout t "Diagnostico: Sinusitis" crlf)
   (printout t "Receta: Descongestionantes y antibioticos (si es bacteriana)" crlf)
   (printout t "observacion: Inhalar vapor y mantenerse hidratado" crlf)
   (assert (diagnostico (nombre sinusitis)))
   (assert (medicamento (nombre Descongestionantes)))
   (assert (medicamento (nombre Antibioticos)))
   (assert (observacion (nombre "Inhalar vapor")))
   (assert (observacion (nombre "Mantenerse hidratado"))))


(defrule alergia
   (symptoma (nombre escurrimiento_nasal))
   (symptoma (nombre tos))
   =>
   (printout t "Diagnostico: Alergia estacional" crlf)
   (printout t "Receta: Antihistaminicos" crlf)
   (printout t "observacion: Evitar alergenos comunes y mantener espacios limpios" crlf)
   (assert (diagnostico (nombre alergia)))
   (assert (medicamento (nombre Antihistaminicos)))
   (assert (observacion (nombre "Evitar alergenos comunes")))
   (assert (observacion (nombre "Mantener espacios limpios"))))

(defrule bronquitis
   (symptoma (nombre tos))
   (symptoma (nombre dificultad_respirar))
   =>
   (printout t "Diagnostico: Bronquitis" crlf)
   (printout t "Receta: Broncodilatadores y mucoliticos" crlf)
   (printout t "observacion: Evitar el humo del cigarro y descansar" crlf)
   (assert (diagnostico (nombre bronquitis)))
   (assert (medicamento (nombre Broncodilatadores)))
   (assert (medicamento (nombre Mucoliticos)))
   (assert (observacion (nombre "Evitar el humo del cigarro")))
   (assert (observacion (nombre "Descansar adecuadamente"))))
