CREATE OR REPLACE FUNCTION obtener_ventas_empleado (id_empleado INTEGER)
RETURNS TABLE (
    nombre_completo VARCHAR(200),
    descripcion_venta VARCHAR(200),
    valor_venta NUMERIC
) AS $$
DECLARE
    empleado_record RECORD;
    venta_record RECORD;
BEGIN
    FOR empleado_record IN SELECT * FROM empleados WHERE ID_Empleado = id_empleado_param
    LOOP
        FOR venta_record IN SELECT CONCAT(empleado_record.primer_nombre, ' ', COALESCE(empleado_record.segundo_nombre, ''), ' ', empleado_record.primer_apellido, ' ', COALESCE(empleado_record.segundo_apellido, '')) AS nombre_completo,
                                     v.Descripcion_Venta,
                                     v.Valor_Venta
                            FROM ventas v
                            WHERE v.ID_Empleado = id_empleado_param
        LOOP
            RETURN NEXT venta_record;
        END LOOP;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE plpgsql;