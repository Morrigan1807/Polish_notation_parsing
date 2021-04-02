<?php
    $total = 0;
    $arr = array();

    foreach($_POST as $key=>$value)
    {
          if ($value > 0)
        {
            $total += $value;
            $arr[$key] = $value;
        }
    }
    $arr['total'] = $total;

    header('Content-Type: application/json');
    echo json_encode($arr);
?>